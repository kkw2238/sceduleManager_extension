package com.sparta.schedulemanager_extension.controller;

import com.sparta.schedulemanager_extension.dto.manager.ManagerRequestDto;
import com.sparta.schedulemanager_extension.dto.manager.ManagerResponseDto;
import com.sparta.schedulemanager_extension.service.ManagerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerController {

    ManagerService managerService;

    ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    /** 스케쥴에 매니져를 추가하는 메서드
     *
     * @param managerRequestDto 매니져를 추가할 스케쥴 Id, 유저 Id, 요청자 Id를 담은 객체
     * @return 해당 스케쥴에 참여하고 있는 모든 유저 Id
     */
    @PutMapping("/managers")
    public List<ManagerResponseDto> addManagerToSchedule(@RequestBody  ManagerRequestDto managerRequestDto) {
        return managerService.addManager(managerRequestDto);
    }
}
