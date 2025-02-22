package com.seguridad.api.service;

import com.seguridad.api.dto.auth.UserDto;
import java.util.List;

public interface UserServ {
    List<UserDto> getAll();
    UserDto getById(String id);
    UserDto save(UserDto userDto);
    UserDto update(UserDto userDto, String id);
    void delete(String id);
}
