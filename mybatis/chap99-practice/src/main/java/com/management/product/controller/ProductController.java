package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;

public class ProductController {

    ProductService productService = new ProductService();
    ProductPrint productPrint = new ProductPrint();

    public void selectAllProductList() {

        List<ProductDTO> allProductList = productService.selectAllProductList();
        productPrint.printAllProductList(allProductList);
    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);
        productPrint.printProductList(productList, searchCondition);

    }

    public void registNewProduct(ProductDTO product) {

        if(productService.registNewProduct(product)){
            productPrint.printSuccessMessage("제품 등록 성공");
        } else {
            productPrint.printErrorMessage("제품 등록 실패");
        }
    }

    public void modifyProductInfo(ProductDTO product) {

        if(productService.modifyProductInfo(product)){
            productPrint.printSuccessMessage("제품 수정 성공");
        } else {
            productPrint.printErrorMessage("제품 수정 실패");
        }

    }

    public void deleteProduct(Map<String, String> parameter) {

        if(productService.deleteProduct(parameter)){
            productPrint.printSuccessMessage("제품 삭제 성공");
        } else {
            productPrint.printErrorMessage("제품 삭제 실패");
        }

    }
}
