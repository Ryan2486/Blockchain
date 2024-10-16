package com.example.block;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.block.Model.Block;
import com.example.block.Model.BlockChain;

@SpringBootApplication
public class BlockApplication {

	private static BlockChain blockChainObj = new BlockChain(5);

	public static void main(String[] args) {
		SpringApplication.run(BlockApplication.class, args);
		System.out.println("Hello, World!");
		List<Block> blockChain = new BlockChain(5).getBlockChain();

		System.out.println(blockChain.get(0).getHash());

	}

	@RestController
	@RequestMapping("/api")
	class LoginController {

		@GetMapping("/")
		public List<Block> postMethodName(@RequestBody Object entity) {
			blockChainObj.addBlock(blockChainObj.generateNextBlock(entity));
			return blockChainObj.getBlockChain();

		}
	}

}
