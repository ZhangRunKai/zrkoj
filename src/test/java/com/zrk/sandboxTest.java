//package com.zrk;
//
//import com.alibaba.fastjson.JSON;
//import com.zrk.entity.sandbox.SandboxSubmit;
//import com.zrk.entity.sandbox.SandboxRequest;
//import com.zrk.entity.sandbox.SandboxResponse;
//import org.junit.jupiter.api.Test;
//
//import java.io.*;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.util.Date;
//
///**
// * @author zhang run kai
// * @version 1.0
// * @date 2021/4/2 15:11
// */
//public class sandboxTest {
//
//    @Test
//    public void testSocket(){
//        Socket socket = null;
//        try {
//            socket = new Socket("127.0.0.1",8890);
//
//            InetAddress inetAddress = socket.getInetAddress();
//            System.out.println("连接到了"+inetAddress);
//
//            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//            SandboxRequest send = sandboxTest.send();
//            String s = JSON.toJSONString(send);
//            printWriter.println(s);
//            printWriter.flush();
//            System.out.println(s);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String res=null;
//            while((res = bufferedReader.readLine()) !=null){
//                SandboxResponse response = JSON.parseObject(res, SandboxResponse.class);
//                System.out.println(response.toString());
//                System.out.println(response.getData());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public static SandboxRequest send(){
//
//        SandboxRequest request = new SandboxRequest();
//        SandboxSubmit problem = new SandboxSubmit();
//        problem.setCode("import java.util.Scanner;\n" +
//                "\n" +
//                "/**\n" +
//                " * @author zhang run kai\n" +
//                " * @version 1.0\n" +
//                " * @date 2021/4/2 15:45\n" +
//                " */\n" +
//                "public class Main {\n" +
//                "    public static void main(String[] args) {\n" +
//                "        Scanner scanner = new Scanner(System.in);\n" +
//                "        while(scanner.hasNext()){\n" +
//                "            String s = scanner.nextLine();\n" +
//                "            System.out.println(s);\n" +
//                "        }\n" +
//                "    }\n" +
//                "}");
//        problem.setDataFilePath("E:\\workspace\\test\\data");
//        problem.setMemoryLimit(12000000);
//        problem.setTimeLimit(1000);
//        problem.setSubmitTime(new Date());
//        problem.setSubmitType("java");
//        problem.setSubmitId(1);
//        request.setCommand("run");
//        request.setProblem(problem);
//        return request;
//    }
//}
