package com.example.API.service;

import com.example.API.dto.request.ProductCreateRequest;
import com.example.API.dto.request.ProductUpdateRequest;
import com.example.API.dto.response.CloudinaryResponse;
import com.example.API.dto.response.category.CategoryDetailResponse;
import com.example.API.dto.response.product.ProductDetailResponse;
import com.example.API.entity.Category;
import com.example.API.entity.Product;
import com.example.API.exception.FuncErrorException;
import com.example.API.exception.NotFoundException;
import com.example.API.repository.CategoryRepository;
import com.example.API.repository.ProductRepository;
import com.example.API.util.FileUploadUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private MessageSource messageSource;
    private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());
    private final static String PRODUCT_NOT_FOUND_CODE = "product.not.found";

    private String getMessage(final String code, final Object... args) {
        return this.messageSource.getMessage(code, args,
                LocaleContextHolder.getLocale());
    }

    public List<ProductDetailResponse> findAll() {
        final List<Product> products = this.repository.findAll();
        return products.stream().map(this::buildProductDetailResponse).toList();
    }

    @Transactional
    public ProductDetailResponse findById(final Integer id)  {
        final Product product = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found"));
        return this.buildProductDetailResponse(product);
    }

    public ProductDetailResponse createProduct(final ProductCreateRequest request)  {
        final Integer  categoryId = request.getCategoryId();
        final Category category   = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Category not found"));
        final Product  product    = Product.builder().build();
        BeanUtils.copyProperties(request, product);
        product.setCategory(category);
        final Product savedProduct = this.repository.save(product);
        return this.buildProductDetailResponse(savedProduct);
    }

    @Transactional
    public void uploadImage(final Integer id, final MultipartFile file) {
        try {
            final Product product = this.repository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Product not found"));
            FileUploadUtil.assertAllowed(file, FileUploadUtil.IMAGE_PATTERN);
            final String fileName = FileUploadUtil.getFileName(file.getOriginalFilename());
            final CloudinaryResponse response = this.cloudinaryService.uploadFile(file, fileName);
            product.setImageUrl(response.getUrl());
            product.setCloudinaryImageId(response.getPublicId());
            this.repository.save(product);
        } catch (NotFoundException e) {
            LOGGER.log(Level.SEVERE, "Product not found with id: " + id, e);
            throw e;
        } catch (FuncErrorException e) {
            LOGGER.log(Level.SEVERE, "Failed to upload file to Cloudinary", e);
            throw e;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error occurred", e);
            throw new RuntimeException("Unexpected error occurred: " + e.getMessage());
        }
    }
    ////


    public ProductDetailResponse updateProduct(final Integer id,
                                               final ProductUpdateRequest request)  {
        final Product product = this.repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDiscount(request.getDiscount());
        final Product savedProduct = this.repository.save(product);
        return this.buildProductDetailResponse(savedProduct);
    }

    public void deleteProduct(final Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        } else {
            throw new NotFoundException("Product not found");
        }
    }

    private ProductDetailResponse buildProductDetailResponse(final Product product) {
        final ProductDetailResponse response = ProductDetailResponse.builder()
                .build();
        BeanUtils.copyProperties(product, response);

        final Category               category         = product.getCategory();
        final CategoryDetailResponse categoryResponse = CategoryDetailResponse.builder()
                .build();
        BeanUtils.copyProperties(category, categoryResponse);
        response.setCategory(categoryResponse);
        return response;
    }

}
