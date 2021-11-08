package com.ecommerce.serviceimpl;

import com.ecommerce.dao.CartDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.modal.Cart;
import com.ecommerce.modal.User;
import com.ecommerce.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CartServiceImpl implements CartService {
    private CartDao cartDao;
    private UserDao userDao;

    public CartServiceImpl(CartDao cartDao, UserDao userDao) {
        this.cartDao = cartDao;
        this.userDao = userDao;
    }

    @Override
    public Cart addCartToUser(Cart cart, long idUser) {
        User user = userDao.findById(idUser).orElse(null);
        user.addCartToUser(cart);

        return cartDao.save(cart);
    }

    @Override
    public void deleteCart(long id) {
        cartDao.deleteById(id);

    }

    @Override
    public List<Cart> findCartsForUser(long idUser) {
        User user = userDao.findById(idUser).orElse(null);
        return user.getCarts();
    }

    @Override
    public Cart findCartById(long id) {
        return cartDao.findById(id).orElse(null);
    }

    @Override
    public void removeFromCart(long idCart, long idUser) {
        User user = userDao.findById(idUser).orElse(null);
        Cart cart = cartDao.findById(idCart).orElse(null);
        user.removeFromCart(cart);
        cartDao.delete(cart);
    }

    @Override
    public Cart findByCartName(String name) {
        Optional<Cart> carts = cartDao.findByName(name);
        if (carts.isPresent()) {
            Cart cart = carts.get();
            return cart;
        }
        return null;
    }
}
