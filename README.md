# API Service

## Spec

- Language : 
Open JDK `1.8`
- Framework : 
Springboot `2.7.2`
Mybatis `2.2.2`
- Database : 
H2 `1.3.176`

## Server

- 서비스 컨테이너 : springboot undertow
    - tomcat 변경 방법
        
        ```xml
        <!-- Undertow : S -->
        		<dependency>
        			<groupId>org.springframework.boot</groupId>
        			<artifactId>spring-boot-starter-web</artifactId>
        			<exclusions>
        				<exclusion>
        					<groupId>org.springframework.boot</groupId>
        					<artifactId>spring-boot-starter-tomcat</artifactId>
        				</exclusion>
        			</exclusions>
        		</dependency>
        
        		<dependency>
        			<groupId>org.springframework.boot</groupId>
        			<artifactId>spring-boot-starter-undertow</artifactId>
        		</dependency>
        		<!-- Undertow : E -->
        ```
        
- 서비스 port : 8080
    - port 변경 방법
        
        ```yaml
        port: ${PORT:8080}
        ```
        
- in-memory DB(H2) Console : /h2-console

## API

- Postman
    
    ```json
    {
    	"info": {
    		"_postman_id": "07eefd65-b7b6-4e36-8aef-48d57f7a48f5",
    		"name": "sample",
    		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
    	},
    	"item": [
    		{
    			"name": "SELECT ALL",
    			"request": {
    				"method": "GET",
    				"header": [],
    				"url": {
    					"raw": "http://localhost:8080/api/v1/sample",
    					"protocol": "http",
    					"host": [
    						"localhost"
    					],
    					"port": "8080",
    					"path": [
    						"api",
    						"v1",
    						"sample"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "SELECT FLUX",
    			"request": {
    				"method": "GET",
    				"header": [],
    				"url": {
    					"raw": "http://localhost:8080/api/v1/sample/flux",
    					"protocol": "http",
    					"host": [
    						"localhost"
    					],
    					"port": "8080",
    					"path": [
    						"api",
    						"v1",
    						"sample",
    						"flux"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "SELECT MONO",
    			"request": {
    				"method": "GET",
    				"header": [],
    				"url": {
    					"raw": "http://localhost:8080/api/v1/sample/mono/1",
    					"protocol": "http",
    					"host": [
    						"localhost"
    					],
    					"port": "8080",
    					"path": [
    						"api",
    						"v1",
    						"sample",
    						"mono",
    						"1"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "SELECT COUNT",
    			"request": {
    				"method": "GET",
    				"header": [],
    				"url": {
    					"raw": "http://localhost:8080/api/v1/sample/count",
    					"protocol": "http",
    					"host": [
    						"localhost"
    					],
    					"port": "8080",
    					"path": [
    						"api",
    						"v1",
    						"sample",
    						"count"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "INSERT MONO",
    			"request": {
    				"method": "POST",
    				"header": [
    					{
    						"key": "Content-Type",
    						"value": "application/json",
    						"type": "default"
    					}
    				],
    				"body": {
    					"mode": "raw",
    					"raw": "{\r\n    \"nm\" : \"post_nm_test_1\",\r\n    \"cn\" : \"post_cn_test_1\"\r\n}"
    				},
    				"url": {
    					"raw": "http://localhost:8080/api/v1/sample",
    					"protocol": "http",
    					"host": [
    						"localhost"
    					],
    					"port": "8080",
    					"path": [
    						"api",
    						"v1",
    						"sample"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "UPDATE MONO",
    			"request": {
    				"method": "PATCH",
    				"header": [
    					{
    						"key": "Content-Type",
    						"value": "application/json",
    						"type": "default"
    					}
    				],
    				"body": {
    					"mode": "raw",
    					"raw": "{\r\n    \"nm\" : \"post_patch_nm_test_1\",\r\n    \"cn\" : \"post_patch_cn_test_1\"\r\n}"
    				},
    				"url": {
    					"raw": "http://localhost:8080/api/v1/sample/mono/1",
    					"protocol": "http",
    					"host": [
    						"localhost"
    					],
    					"port": "8080",
    					"path": [
    						"api",
    						"v1",
    						"sample",
    						"mono",
    						"1"
    					]
    				}
    			},
    			"response": []
    		},
    		{
    			"name": "DELETE MONO",
    			"request": {
    				"method": "DELETE",
    				"header": [
    					{
    						"key": "Content-Type",
    						"value": "application/json",
    						"type": "default"
    					}
    				],
    				"body": {
    					"mode": "raw",
    					"raw": "{\r\n    \"nm\" : \"post_patch_nm_test_1\",\r\n    \"cn\" : \"post_patch_cn_test_1\"\r\n}"
    				},
    				"url": {
    					"raw": "http://localhost:8080/api/v1/sample/mono/1",
    					"protocol": "http",
    					"host": [
    						"localhost"
    					],
    					"port": "8080",
    					"path": [
    						"api",
    						"v1",
    						"sample",
    						"mono",
    						"1"
    					]
    				}
    			},
    			"response": []
    		}
    	]
    }
    ```
    

## 실행 방법

```yaml
# 기본
$ java -jar [배포된 jar 파일 명]

# 백그라운드 실행
$ java -jar [배포된 jar 파일 명] &

# 실행한 사용자가 로그아웃시에도 유지 (no hang up)
$ nohup java -jar [배포된 jar 파일 명] &

# jar console log file을 원하는 경로에 관리하고 싶으면
$ nohup java -jar [배포된 jar 파일 명] > [원하는 파일 경로 & 파일명]
$ nohup java -jar sample.jar > log/sample.out

# jar console log file을 원하지 않을 경우
$ nohup java -jar [배포된 jar 파일 명] > /dev/null
$ nohup java -jar sample.jar > /dev/null

# console log 확인 방법
$ tail -f [console log file]
$ tail -f log/sample.out

# 종료 방법
$ ps -ef || grep [배포된 jar 명]
$ ps -ef || grep sample
# PID 확인
$ kill -9 [배포된 jar 프로세스 ID]
$ kill -9 1111
```
