package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> allProductList) {

        if (allProductList != null && !allProductList.isEmpty()) {
            for (ProductDTO productDTO : allProductList) {
                System.out.println(productDTO);
            }
        }else{
            System.out.println("조회 결과 없음.");
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        if (productList != null && !productList.isEmpty()) {
            System.out.println("===== " + searchCondition.getCondition() + " 조건으로 검색한 결과입니다. =====");
            for (ProductDTO productDTO : productList) {
                System.out.println(productDTO);
            }
        }else{
            System.out.println("조회 결과 없음.");
        }
    }

    public void printSuccessMessage(String successCode) {

        System.out.println(successCode);

    }

    public void printErrorMessage(String errorCode) {

        System.out.println(errorCode);
    }

}
