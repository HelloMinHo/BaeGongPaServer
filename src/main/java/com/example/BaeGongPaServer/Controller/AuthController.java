package com.example.BaeGongPaServer.Controller;

import com.example.BaeGongPaServer.Component.ApiResponse;
import com.example.BaeGongPaServer.DTO.AuthDTO;
<<<<<<< HEAD
import com.example.BaeGongPaServer.Service.AuthService;
import org.springframework.http.ResponseEntity;
=======
import com.example.BaeGongPaServer.DTO.MemInfoDto;
import com.example.BaeGongPaServer.Service.AuthService;
import com.example.BaeGongPaServer.Service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
<<<<<<< HEAD
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> signIn(@RequestBody HashMap<String, String> params) {


        System.out.println(params.get("memNo"));
=======
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final MemberInfoService memInfoService;


//
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public ResponseEntity<?> signIn(@RequestBody HashMap<String, String> params) {
//
//
//        System.out.println(params.get("memNo"));
//
//
//        return null;
//    }
//
//    @RequestMapping(value = "/test/signIn", method = RequestMethod.POST)
//    public ApiResponse main(@RequestBody AuthDTO authDTO) {
//        ApiResponse apiResponse = authService.memberLogin(authDTO);
//        System.out.println("apiResponse"+apiResponse);
//
//        return apiResponse;
//    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ApiResponse signUp(@RequestBody AuthDTO authDTO) {
        ApiResponse apiResponse = authService.memberLogin(authDTO);
        System.out.println("apiResponse" + apiResponse);

        return apiResponse;
    }


    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ApiResponse signIn(@RequestBody MemInfoDto memInfoDto) {
        ApiResponse apiResponse = memInfoService.createMemInfo(memInfoDto);
        System.out.println("apiResponse" + apiResponse);

        return apiResponse;
    }

    @RequestMapping(value = "/user/roomList", method = RequestMethod.POST)
    public ApiResponse userRoomList(@AuthenticationPrincipal UserDetails userDetails, @RequestParam HashMap<String,String> params) {

        System.out.println("getUsername : " + userDetails.getUsername());
        System.out.println("getPassword : " + userDetails.getPassword());
//        ApiResponse apiResponse = memInfoService.createMemInfo(memInfoDTO);
        System.out.println("params : " + params);
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144


        return null;
    }

<<<<<<< HEAD
    @RequestMapping(value = "/test/signIn", method = RequestMethod.POST)
    public ApiResponse testIn(@RequestBody AuthDTO authDTO) {
        ApiResponse apiResponse = authService.memberLogin(authDTO);
        System.out.println("apiResponse"+apiResponse);

        return apiResponse;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ApiResponse mainIn(@RequestBody AuthDTO authDTO) {
        ApiResponse apiResponse = authService.memberLogin(authDTO);
        System.out.println("apiResponse"+apiResponse);

        return apiResponse;
=======
    @RequestMapping(value = "/roomList", method = RequestMethod.POST)
    public ApiResponse allRoomList(@AuthenticationPrincipal UserDetails userDetails, @RequestParam HashMap<String,String> params) {

        System.out.println("getUsername : " + userDetails.getUsername());
        System.out.println("getPassword : " + userDetails.getPassword());
//        ApiResponse apiResponse = memInfoService.createMemInfo(memInfoDTO);



        return null;
>>>>>>> fea833fbf35f24921e3c8ac6b38f284abce9c144
    }
}
