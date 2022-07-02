SELECT @@sql_mode;

SET @@sql_mode = "ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION"

CREATE TABLE bgp.mem_info (
mem_no		INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '회원번호',
mem_id		VARCHAR(255) NOT NULL DEFAULT '' COMMENT '접속아이디',
mem_pwd		VARCHAR(255) NOT NULL DEFAULT '' COMMENT '접속비밀번호',
mem_nick	VARCHAR(100) NOT NULL DEFAULT '' COMMENT '회원 닉네임',
mem_bg_photo	VARCHAR(255) NOT NULL DEFAULT '' COMMENT '회원 배경 사진',
mem_pf_photo	VARCHAR(255) NOT NULL DEFAULT '' COMMENT '회원 프로필 사진',
mem_roll	INT NOT NULL DEFAULT 0 COMMENT '회원권한구분[코드:a001]',
auth_slct	CHAR(1) NOT NULL DEFAULT '' COMMENT '인증구분[a:패스,b:공인인증서..]',
auth_phone	VARCHAR(20) NOT NULL DEFAULT '' COMMENT '연락처(인증)',
auth_name	VARCHAR(20) NOT NULL DEFAULT '' COMMENT '성명(인증)',
auth_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최초인증일자',
ins_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최초등록일자',
upd_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최종수정일자'
) COMMENT '회원 정보';


CREATE TABLE bgp.room_info (
room_no		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY  COMMENT '방 번호',
room_name	VARCHAR(255) NOT NULL DEFAULT '' COMMENT '방 제목',
room_sub	VARCHAR(255) NOT NULL DEFAULT '' COMMENT '방 설명',
area_l_code	INT	NOT NULL DEFAULT 0 COMMENT '지역(대)',
area_m_code	INT	NOT NULL DEFAULT 0 COMMENT '지역(중)',
area_s_code	INT	NOT NULL DEFAULT 0 COMMENT '지역(소)',
addr_detail	VARCHAR(255) NOT NULL DEFAULT '' COMMENT '지역상세',
host_mem_no	INT	NOT NULL DEFAULT 0 COMMENT '회원번호(방장)',
sub_mem_no	INT	NOT NULL DEFAULT 0 COMMENT '회원번호(부방장)',
invite_code	VARCHAR(20) NOT NULL DEFAULT '' COMMENT '초대코드',
ins_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최초등록일자',
upd_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최종수정일자',
FOREIGN KEY(host_mem_no) REFERENCES bgp.mem_info(mem_no) ON DELETE CASCADE
) COMMENT '주문방 정보';


CREATE TABLE bgp.order_info (
order_no	BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY  COMMENT '주문 번호',
order_name	VARCHAR(50) NOT NULL DEFAULT '' COMMENT '주문 제목',
order_sub	VARCHAR(50) NOT NULL DEFAULT '' COMMENT '주문 설명',
room_no		BIGINT NOT NULL DEFAULT 0 COMMENT '방 번호',
order_mem_no	INT	NOT NULL DEFAULT 0 COMMENT '회원번호(주문자)',
order_able_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '주문가능일자',
order_rcv_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '주문도착예상일자',
pre_pay_yn	ENUM('y','n') NOT NULL DEFAULT 'y' COMMENT '선불결제여부[y:선불,n:후불]',
menu_box_yn	ENUM('y','n') NOT NULL DEFAULT 'n' COMMENT '메뉴박스사용여부',
menu_box_no	BIGINT NOT NULL DEFAULT 0 COMMENT '메뉴박스 번호',
order_end_yn	ENUM('y','n') NOT NULL DEFAULT 'n' COMMENT '주문완료처리여부[y:완료,n:미완료]',
order_end_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '주문완료처리일자',
ins_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최초등록일자',
upd_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최종수정일자',
FOREIGN KEY(room_no) REFERENCES bgp.room_info(room_no) ON DELETE CASCADE
) COMMENT '주문 정보';


CREATE TABLE bgp.menu_box_info (
menu_box_no	BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY  COMMENT '메뉴박스 번호',
menu_box_name	VARCHAR(50) NOT NULL DEFAULT '' COMMENT '메뉴박스 이름',
menu_box_sub 	VARCHAR(50) NOT NULL DEFAULT '' COMMENT '메뉴박스 설명',
menu_cnt	INT	NOT NULL DEFAULT 0 COMMENT '메뉴 수',
room_no		BIGINT NOT NULL DEFAULT 0 COMMENT '방 번호',
ins_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최초등록일자',
upd_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최종수정일자',
FOREIGN KEY(room_no) REFERENCES room_info(room_no) ON DELETE CASCADE
) COMMENT '메뉴 박스 정보';


CREATE TABLE bgp.menu_info (
menu_no		BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY  COMMENT '메뉴 번호',
menu_name	VARCHAR(50) NOT NULL DEFAULT '' COMMENT '메뉴 이름',
menu_sub	VARCHAR(50) NOT NULL DEFAULT '' COMMENT '메뉴 설명',
menu_price	DECIMAL(10,2) NOT NULL DEFAULT 0.00 COMMENT '메뉴 가격',
menu_box_no	BIGINT NOT NULL DEFAULT 0 COMMENT '메뉴박스 번호',
ins_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최초등록일자',
upd_date	DATETIME(6) NOT NULL DEFAULT '000-00-00 00:00:00.000000' COMMENT '최종수정일자',
FOREIGN KEY(menu_box_no) REFERENCES bgp.menu_box_info(menu_box_no) ON DELETE CASCADE
) COMMENT '메뉴 정보';









select * from mem_info;
