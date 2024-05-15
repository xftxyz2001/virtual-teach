package com.xftxyz.virtualteach.controller;

import com.xftxyz.virtualteach.domain.SystemNotification;
import com.xftxyz.virtualteach.service.SystemNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notification")
public class NotificationController {

    private final SystemNotificationService systemNotificationService;

    @GetMapping("/list")
    public List<SystemNotification> getNotificationList() {
        return systemNotificationService.list();
    }
}
