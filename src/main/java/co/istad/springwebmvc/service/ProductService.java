package co.istad.springwebmvc.service;import co.istad.springwebmvc.dto.ProductDto;import co.istad.springwebmvc.dto.ProductCreateRequest;import co.istad.springwebmvc.dto.ProductEdit;import java.util.List;public interface ProductService {    void editProductByUuid(String uuid,ProductEdit request);    void createNewProduct(ProductCreateRequest request);    List<ProductDto> findProducts(String name, Boolean status);    ProductDto findProductById(Integer id);    ProductDto findProductByUuid(String uuid);}