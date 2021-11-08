package com.ecommerce;

import com.ecommerce.modal.Category;
import com.ecommerce.modal.Product;
import com.ecommerce.modal.User;
import com.ecommerce.service.CartService;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.UserService;
import com.ecommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }


  //  @Bean
  //  CommandLineRunner runner(UserService userService, CategoryService categoryService,ProductService productService  ) {
  //      return args -> {
  //          userService.addUser(new User("abdoulkarim", "babani1234",true,"garba.babani@gmail.com", "babani", "123", 124,"225 Alouazzani",null,null));
   //         userService.addUser(new User("abdouaye", "cherif1234",false,"cherif@gmail.com", "cherif", "124", 231,"agdal",null,null));

         //    categoryService.addCategoryToUser(new Category("computer",new User("abdoulkarim", "babani1234",true,"garba.babani@gmail.com", "babani", "123", 124,"225 Alouazzani",null,null),null),1);
          //           categoryService.addCategoryToUser(new Category("tee shirts",new User("abdoulkarim", "babani1234",true,"garba.babani@gmail.com", "babani", "123", 124,"225 Alouazzani",null,null),null),1);
          //          categoryService.addCategoryToUser(new Category("parfum",null,null),2);
            // more products




          //productService.addProductToCategory(new Product("2.0 V-Neck Short-Sleeve T-Shirt"," 14\"Under Armour Men's Tech 2.0 V-Neck Short-Sleeve T-Shirt",	19.99 ,"https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/9f29f0b8-8eb7-4763-8399-015ffbffe959/tee-shirt-de-basketball-dri-fit-lebron-space-jam-a-new-legacy-pour-s3fkFS.png",null,null,null),2);


   //     };

  //  }
}