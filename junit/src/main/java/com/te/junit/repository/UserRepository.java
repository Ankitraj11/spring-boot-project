package com.te.junit.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.te.junit.dto.UserDto;

public interface UserRepository  extends CrudRepository<UserDto, Integer>{

	public Optional<UserDto> findByUserId(int id);
}
