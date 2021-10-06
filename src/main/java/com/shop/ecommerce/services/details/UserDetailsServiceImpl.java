package com.shop.ecommerce.services.details;

import java.util.Arrays;

import com.shop.ecommerce.domain.users.Client;
import com.shop.ecommerce.domain.users.Seller;
import com.shop.ecommerce.repositories.ClientRepository;
import com.shop.ecommerce.repositories.SellerRepository;
import com.shop.ecommerce.security.ClientSS;
import com.shop.ecommerce.security.SellerSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private SellerRepository sellerRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Client cli = clientRepo.findByEmail(email);

		if (cli == null) {
			Seller sel = sellerRepo.findByEmail(email);

			SellerSS selSS = new SellerSS();

			selSS.setId(sel.getId());
			selSS.setEmail(sel.getEmail());
			selSS.setPassword(sel.getPassword());
			selSS.setAuthorities(Arrays.asList(sel.getType()));

			return selSS;
		}

		ClientSS cliSS = new ClientSS();

		cliSS.setId(cli.getId());
		cliSS.setEmail(cli.getEmail());
		cliSS.setPassword(cli.getPassword());
		cliSS.setAuthorities(Arrays.asList(cli.getType()));

		return cliSS;
	}

}
