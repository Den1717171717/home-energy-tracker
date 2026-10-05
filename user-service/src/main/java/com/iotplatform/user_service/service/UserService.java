package com.iotplatform.user_service.service;

import com.iotplatform.user_service.dto.UserDto;
import com.iotplatform.user_service.entity.User;
import com.iotplatform.user_service.handler.UserNotFoundException;
import com.iotplatform.user_service.mapStruct.UserMapper;
import com.iotplatform.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;
    public UserDto createUser(UserDto input)
    {
        final User createdUser = User.builder()
                .name(input.getName())
                .surname(input.getSurname())
                .email(input.getEmail())
                .address(input.getAddress())
                .alerting(input.isAlerting())
                .energyAlertingThreshold(input.getEnergyAlertingThreshold())
                .build();

        userRepository.save(createdUser);



        return userMapper.toUserDto(createdUser);
    }
    public UserDto getUserById(Long id)
    {
        return userRepository.findById(id).map(userMapper::toUserDto).orElseThrow(()-> new UserNotFoundException(id));
    }

    public void updateUser(Long id , UserDto userDto)
    {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setAlerting(userDto.isAlerting());
        user.setEnergyAlertingThreshold(userDto.getEnergyAlertingThreshold());
        userRepository.save(user);
    }
    public void deleteUser(Long id)
    {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        userRepository.delete(user);
    }

}
