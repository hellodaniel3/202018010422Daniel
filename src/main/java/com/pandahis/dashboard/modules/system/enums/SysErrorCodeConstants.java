package com.pandahis.dashboard.modules.system.enums;

import com.pandahis.dashboard.common.exception.ErrorCode;

/**
 * System 错误码枚举类
 *
 * system 系统，使用 1-002-000-000 段
 */
public interface SysErrorCodeConstants {

    // ========== AUTH 模块 1002000000 ==========
    ErrorCode AUTH_LOGIN_BAD_CREDENTIALS = new ErrorCode(1002000000, "Login failed, incorrect account and password");
    ErrorCode AUTH_LOGIN_USER_DISABLED = new ErrorCode(1002000001, "Login failed, account disabled");
    ErrorCode AUTH_LOGIN_FAIL_UNKNOWN = new ErrorCode(1002000002, "Login failed"); // 登陆失败的兜底，位置原因
    ErrorCode AUTH_LOGIN_CAPTCHA_NOT_FOUND = new ErrorCode(1002000003, "The verification code does not exist");
    ErrorCode AUTH_LOGIN_CAPTCHA_CODE_ERROR = new ErrorCode(1002000004, "Incorrect verification code");
    // ========== TOKEN 模块 1002001000 ==========
    ErrorCode TOKEN_EXPIRED = new ErrorCode(1002001000, "Token Expired");
    ErrorCode TOKEN_PARSE_FAIL = new ErrorCode(1002001001, "Token Parsing failed");
    // ========== 菜单模块 1002002000 ==========
    ErrorCode MENU_NAME_DUPLICATE = new ErrorCode(1002002000, "A menu with that name already exists");
    ErrorCode MENU_PARENT_NOT_EXISTS = new ErrorCode(1002002001, "The parent menu does not exist");
    ErrorCode MENU_PARENT_ERROR = new ErrorCode(1002002002, "Cannot set oneself as the parent menu");
    ErrorCode MENU_NOT_EXISTS = new ErrorCode(1002002003, "The menu does not exist");
    ErrorCode MENU_EXISTS_CHILDREN = new ErrorCode(1002002004, "There is a submenu that cannot be deleted");
    ErrorCode MENU_PARENT_NOT_DIR_OR_MENU = new ErrorCode(1002002005, "The type of parent menu must be directory or menu");
    // ========== 角色模块 1002003000 ==========
    ErrorCode ROLE_NOT_EXISTS = new ErrorCode(1002003000, "Character does not exist");
    ErrorCode ROLE_NAME_DUPLICATE = new ErrorCode(1002003001, "A role named {}} already exists");
    ErrorCode ROLE_CODE_DUPLICATE = new ErrorCode(1002003002, "A role with code [{}}] already exists");
    ErrorCode ROLE_CAN_NOT_UPDATE_SYSTEM_TYPE_ROLE = new ErrorCode(1002003004, "Cannot operate on roles with built-in system types");
    // ========== 用户模块 1002004000 ==========
    ErrorCode USER_USERNAME_EXISTS = new ErrorCode(1002004000, "The user account already exists");
    ErrorCode USER_MOBILE_EXISTS = new ErrorCode(1002004001, "The phone number already exists");
    ErrorCode USER_EMAIL_EXISTS = new ErrorCode(1002004002, "Email already exists");
    ErrorCode USER_NOT_EXISTS = new ErrorCode(1002004003, "user does not exist");
    ErrorCode USER_IMPORT_LIST_IS_EMPTY = new ErrorCode(1002004004, "Importing user data cannot be empty！");
    ErrorCode USER_PASSWORD_FAILED = new ErrorCode(1002004005, "User password verification failed");
    // ========== 科室模块 1002005000 ==========
    ErrorCode DEPT_NAME_DUPLICATE = new ErrorCode(1002004001, "A department with that name already exists");
    ErrorCode DEPT_PARENT_NOT_EXITS = new ErrorCode(1002004002,"Parent department does not exist");
    ErrorCode DEPT_NOT_FOUND = new ErrorCode(1002004003, "The current department does not exist");
    ErrorCode DEPT_EXITS_CHILDREN = new ErrorCode(1002004004, "There are sub departments that cannot be deleted");
    ErrorCode DEPT_PARENT_ERROR = new ErrorCode(1002004005, "Cannot set oneself as the parent department");
    ErrorCode DEPT_EXISTS_USER = new ErrorCode(1002004006, "There are employees in the department and they cannot be deleted");
    ErrorCode DEPT_NOT_ENABLE = new ErrorCode(1002004007, "The department is not in an open state and selection is not allowed");
    ErrorCode DEPT_PARENT_IS_CHILD = new ErrorCode(1002004008, "Cannot set one's own sub department as the parent department");
    // ========== 岗位模块 1002005000 ==========
    ErrorCode POST_NOT_FOUND = new ErrorCode(1002005001, "The current position does not exist");
    ErrorCode POST_NOT_ENABLE = new ErrorCode(1002005002, "Position ({}) is not in an open state and cannot be selected");
    ErrorCode POST_NAME_DUPLICATE = new ErrorCode(1002005001, "A position with that name already exists");
    ErrorCode POST_CODE_DUPLICATE = new ErrorCode(1002005001, "The position with this identifier already exists");
    // ========== 字典类型 1002006000 ==========
    ErrorCode DICT_TYPE_NOT_EXISTS = new ErrorCode(1002006001, "The current dictionary type does not exist");
    ErrorCode DICT_TYPE_NOT_ENABLE = new ErrorCode(1002006002, "Dictionary type is not in the enabled state and selection is not allowed");
    ErrorCode DICT_TYPE_NAME_DUPLICATE = new ErrorCode(1002006003, "A dictionary type with that name already exists");
    ErrorCode DICT_TYPE_TYPE_DUPLICATE = new ErrorCode(1002006004, "A dictionary type of this type already exists");
    ErrorCode DICT_TYPE_HAS_CHILDREN = new ErrorCode(1002006004, "Unable to delete, this dictionary type still has dictionary data");
    // ========== 字典数据 1002007000 ==========
    ErrorCode DICT_DATA_NOT_EXISTS = new ErrorCode(1002007001, "The current dictionary data does not exist");
    ErrorCode DICT_DATA_NOT_ENABLE = new ErrorCode(1002007002, "Dictionary data is not in an open state and selection is not allowed");
    ErrorCode DICT_DATA_VALUE_DUPLICATE = new ErrorCode(1002007003, "Dictionary data for this value already exists");
    // ========== 通知公告 1002008000 ==========
    ErrorCode NOTICE_NOT_FOUND = new ErrorCode(1002008001, "The current notification announcement does not exist");
    // ========== 文件 1002009000 ==========
    ErrorCode FILE_PATH_EXISTS = new ErrorCode(1002009001, "The file path already exists");
    ErrorCode FILE_UPLOAD_FAILED = new ErrorCode(1002009002, "File upload failed");
    ErrorCode FILE_IS_EMPTY= new ErrorCode(1002009003, "The file is empty");

}
