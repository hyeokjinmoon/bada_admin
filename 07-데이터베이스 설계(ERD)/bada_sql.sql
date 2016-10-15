-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bada
-- -----------------------------------------------------
-- 바다 DB
DROP SCHEMA IF EXISTS `bada` ;

-- -----------------------------------------------------
-- Schema bada
--
-- 바다 DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bada` DEFAULT CHARACTER SET utf8 ;
USE `bada` ;

-- -----------------------------------------------------
-- Table `bada`.`member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bada`.`member` ;

CREATE TABLE IF NOT EXISTS `bada`.`member` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '일련번호',
  `user_id` VARCHAR(20) NOT NULL COMMENT '아이디',
  `user_pw` VARCHAR(255) NOT NULL COMMENT '비밀번호',
  `name` VARCHAR(10) NOT NULL COMMENT '이름',
  `email` VARCHAR(50) NOT NULL COMMENT '이메일',
  `tel` VARCHAR(15) NOT NULL COMMENT '전화번호',
  `postcode` CHAR(5) NULL COMMENT '우편번호',
  `addr1` VARCHAR(100) NULL COMMENT '주소',
  `addr2` VARCHAR(100) NULL COMMENT '상세 주소',
  `profile_img` VARCHAR(255) NULL COMMENT '프로필 이미지',
  `reg_date` DATETIME NOT NULL COMMENT '등록일',
  `edit_date` DATETIME NOT NULL COMMENT '정보 수정일',
  `is_admin` CHAR(1) NOT NULL COMMENT '어드민 플래그\n어드민=‘T’\n일반회원=’F’',
  `is_active` CHAR(1) NOT NULL COMMENT '회원 활성화 상태\n활성=’T’\n비활성=‘F’',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '회원테이블';


-- -----------------------------------------------------
-- Table `bada`.`book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bada`.`book` ;

CREATE TABLE IF NOT EXISTS `bada`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '일련번호',
  `name` VARCHAR(100) NOT NULL COMMENT '상품명',
  `list_price` INT NOT NULL COMMENT '정가',
  `sale_price` INT NOT NULL COMMENT '판매가',
  `book_img` VARCHAR(255) NULL COMMENT '상품 이미지',
  `reg_date` DATETIME NOT NULL COMMENT '등록일',
  `edit_date` DATETIME NOT NULL COMMENT '수정일',
  `seller` CHAR(1) NOT NULL COMMENT '판매자 \n회원=‘M’, \n바다=‘B’',
  `ok_status` CHAR(1) NOT NULL COMMENT '승인상태 \n승인=‘O’, \n거절=‘R’,\n승인대기=‘W’',
  `seller_id` INT NOT NULL COMMENT '상품 판매자 아이디',
  PRIMARY KEY (`id`),
  INDEX `fk_book_member_idx` (`seller_id` ASC),
  CONSTRAINT `fk_book_member`
    FOREIGN KEY (`seller_id`)
    REFERENCES `bada`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '상품 테이블';


-- -----------------------------------------------------
-- Table `bada`.`noti_faq`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bada`.`noti_faq` ;

CREATE TABLE IF NOT EXISTS `bada`.`noti_faq` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '일련번호',
  `category` VARCHAR(10) NOT NULL COMMENT '게시물 카테고리\n공지사항=‘notice’,\n자주묻는 질문=‘faq’',
  `subject` VARCHAR(50) NOT NULL COMMENT '게시물 제목',
  `content` TEXT NOT NULL COMMENT '게시물 내용',
  `reg_date` DATETIME NOT NULL COMMENT '등록일',
  `edit_date` DATETIME NOT NULL COMMENT '수정일',
  `admin_id` INT NOT NULL COMMENT '관리자 아이디',
  PRIMARY KEY (`id`),
  INDEX `fk_noti_faq_member1_idx` (`admin_id` ASC),
  CONSTRAINT `fk_noti_faq_member1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `bada`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '공지사항, 자주묻는 질문 테이블';


-- -----------------------------------------------------
-- Table `bada`.`qna`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bada`.`qna` ;

CREATE TABLE IF NOT EXISTS `bada`.`qna` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '일련번호',
  `subject` VARCHAR(50) NOT NULL COMMENT '제목',
  `req_type` CHAR(1) NOT NULL COMMENT '문의 종류\n판매=’S’\n환불=‘D’\n배송=‘R’\n기타=‘E’',
  `content` TEXT NOT NULL COMMENT '내용',
  `answer` TEXT NULL COMMENT '답변 내용',
  `answer_status` CHAR(1) NOT NULL COMMENT '답변 상태 \n답변=‘A’,\n미답변=’N’',
  `reg_date` DATETIME NOT NULL COMMENT '등록일',
  `edit_date` DATETIME NOT NULL COMMENT '수정일',
  `request_id` INT NOT NULL COMMENT '질문자 일련번호',
  `answer_id` INT NOT NULL COMMENT '답변자 일련번호',
  PRIMARY KEY (`id`),
  INDEX `fk_qna_member1_idx` (`request_id` ASC),
  INDEX `fk_qna_member2_idx` (`answer_id` ASC),
  CONSTRAINT `fk_qna_member1`
    FOREIGN KEY (`request_id`)
    REFERENCES `bada`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qna_member2`
    FOREIGN KEY (`answer_id`)
    REFERENCES `bada`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '1:1 질문';


-- -----------------------------------------------------
-- Table `bada`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bada`.`order` ;

CREATE TABLE IF NOT EXISTS `bada`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '주문 일련번호',
  `order_date` DATETIME NOT NULL COMMENT '주문일',
  `buyer_id` INT NOT NULL COMMENT '구매자 일련번호',
  `deposit_status` CHAR(1) NOT NULL COMMENT '입금 상태\n입금대기=‘W’,\n입금완료=‘C’',
  `delivery_status` CHAR(1) NOT NULL COMMENT '배송상태\n배송대기=‘W’\n배송중=’S’\n배송완료=‘C’',
  `buyer_addr` VARCHAR(255) NOT NULL COMMENT '구매자 주소',
  `seller_addr` VARCHAR(255) NOT NULL COMMENT '판매자 주소',
  `payment_type` CHAR(1) NOT NULL COMMENT '결제 종류\n현금결제=‘P’\n카드결제=‘C’',
  `payment_price` INT NOT NULL COMMENT '결제 금액',
  INDEX `buyer_id_idx` (`buyer_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `buyer_id`
    FOREIGN KEY (`buyer_id`)
    REFERENCES `bada`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '주문 테이블';


-- -----------------------------------------------------
-- Table `bada`.`cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bada`.`cart` ;

CREATE TABLE IF NOT EXISTS `bada`.`cart` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '일련번호',
  `name` VARCHAR(100) NOT NULL COMMENT '도서명',
  `list_price` INT NOT NULL COMMENT '정가',
  `sale_price` INT NOT NULL COMMENT '판매가',
  `book_img` VARCHAR(255) NULL COMMENT '도서 이미지',
  `reg_date` DATETIME NOT NULL COMMENT '도서 등록일',
  `edit_date` DATETIME NOT NULL COMMENT '도서 정보 수정일',
  `seller` CHAR(1) NOT NULL COMMENT '판매자 \n회원=‘M’, \n바다=‘B’',
  `ok_status` CHAR(1) NOT NULL COMMENT '승인상태 \n승인=‘O’, \n거절=‘R’,\n승인대기=‘W’',
  `seller_id` INT NOT NULL COMMENT '판매자 일련번호\n',
  `book_status` CHAR(1) NOT NULL COMMENT '제품 상태\n판매중=‘W’\n판매완료=‘C’',
  `order_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cart_order1_idx` (`order_id` ASC),
  CONSTRAINT `fk_cart_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `bada`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '장바구니';


-- -----------------------------------------------------
-- Table `bada`.`sales_req`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bada`.`sales_req` ;

CREATE TABLE IF NOT EXISTS `bada`.`sales_req` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '일련번호',
  `sales_type` CHAR(1) NOT NULL COMMENT '판매 종류\n단품=’S’,\n대량=‘B’',
  `book_list` VARCHAR(255) NOT NULL COMMENT '상품 리스트',
  `reg_date` DATETIME NOT NULL COMMENT '등록일',
  `edit_date` DATETIME NOT NULL COMMENT '수정일',
  `pickup_date` DATETIME NOT NULL COMMENT '수거 가능일',
  `member_id` INT NOT NULL,
  `sales_ok` CHAR(1) NOT NULL COMMENT '바다에 판매 승인\n승인대기=‘W’,\n승인=‘O’,\n거절=‘R’',
  PRIMARY KEY (`id`),
  INDEX `fk_sales_req_member1_idx` (`member_id` ASC),
  CONSTRAINT `fk_sales_req_member1`
    FOREIGN KEY (`member_id`)
    REFERENCES `bada`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '바다에 판매 요청';


-- -----------------------------------------------------
-- Table `bada`.`message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bada`.`message` ;

CREATE TABLE IF NOT EXISTS `bada`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '일련번호',
  `content` TEXT NOT NULL COMMENT '내용',
  `reg_date` DATETIME NOT NULL COMMENT '보낸 날짜',
  `sender_id` INT NOT NULL COMMENT '보낸 사람',
  `receiver_id` INT NOT NULL COMMENT '받는 사람',
  PRIMARY KEY (`id`),
  INDEX `sender_id_idx` (`sender_id` ASC),
  INDEX `receiver_id_idx` (`receiver_id` ASC),
  CONSTRAINT `sender_id`
    FOREIGN KEY (`sender_id`)
    REFERENCES `bada`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `receiver_id`
    FOREIGN KEY (`receiver_id`)
    REFERENCES `bada`.`member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '쪽지함 테이블';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
