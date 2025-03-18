package com.grepp.mc;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.grepp.mc.infra.error.CommonException;
import com.grepp.mc.infra.util.QrCodeUtil;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) throws WriterException {
        Scanner sc = new Scanner(System.in);
        System.out.print("파일명 : ");
        String name = sc.nextLine();
        System.out.print("qrcode로 만들 문자열 : ");
        String content = sc.nextLine();
        String format = "png";

        try (FileOutputStream fos = new FileOutputStream(name + "." + format)) {
            QrCodeUtil.createQrCode(format, content, fos);
        } catch (CommonException | IOException e) {
            e.printStackTrace();
        }
    }

}
