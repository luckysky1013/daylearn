import java.io.*;

/**
 * @author liujian
 * @date 2018/9/25
 */
public class IOTest {
	private void operateAllFileCredit(String childFilePath, int encOrDec)
			throws Exception {
		BufferedOutputStream bufferedOutputStream = null;
		DataInputStream din = null;
		FileInputStream fis = null;
		// String str;
		StringBuffer str = new StringBuffer();
		String result = "";
		byte[] buff = new byte[Constant.READ_SIZE];
		byte[] zekbuf = new byte[2];
		String Zek = "";
		long pos = 0;
		try {
			// 读文件
			newFileName = fileSavePath
					+ "\\"
					+ childFilePath.substring(
					childFilePath.lastIndexOf("\\") + 1,
					childFilePath.lastIndexOf("."))
					+ "_FILEDECRYPTED.zip";
			bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(new File(newFileName)));

			fis = new FileInputStream(new File(childFilePath));
			din = new DataInputStream(fis);
			boolean flag_1 = false;
			// int byteNum = 240;

			byte[] temp = new byte[Constant.READ_SIZE];
			byte[] zek = new byte[2];
			int n = 0;
			int size = 0;
			String strtemp = "";
			int dataBuffCount = 0;
			log.debug("到达读取key处");

			// 读取ZEK密文
			n = din.read(zekbuf);
			int zekLenNum = Integer.parseInt(new String(zekbuf));
			zek = new byte[zekLenNum];
			n = din.read(zek);
			Zek = new String(zek);
			String ZEKstrDES = null;
			String ZMK = null;
			// 测试环境下软解出ZEK
			if (testFlag) {
				String LMK0405 = "40404040404040405151515151515151";
				ZMK = WD3DesCryptoUtil.ecb_decrypt(LMK0405, Constant.TEST_ZMK,
						Padding.ZeroBytePadding);
				ZEKstrDES = WD3DesCryptoUtil.ecb_decrypt(ZMK, Zek,
						Padding.ZeroBytePadding);
				System.out.println(ZEKstrDES);
			} else {
				// 生产环境加密机解ZMK下ZEK出ZEK密文
				if (testZmkFlag) {
					ZEKstrDES = ZmkToZekSJJ(Constant.TEST_ZMK, Zek, "ZEK");
				} else {
					ZEKstrDES = ZmkToZekSJJ(Constant.CREDIT_ZMK, Zek, "ZEK");
				}
				log.debug(ZEKstrDES);
			}
			log.debug("到达读取数据处");
			n = din.read(temp);
			// 用ZEK解密数据(FK)
			// HEX解码
			// 写文件.zip
			do {
				/**
				 * 写文件
				 */
				/*
				 * bufferedOutputStream.write(WDByteUtil.HEX2Bytes(result));
				 * size += byteNum; if(size % (1024*100) == 0){
				 * EncOrDecFileWindow.addLog("已处理: " + size/1024 + " K数据"); }
				 */
				if (flag_1) {
					log.debug("before_hex_decode::" + result);
					log.debug(Hex.decode(result));
					bufferedOutputStream.write(Hex.decode(result));
				} else {
					flag_1 = true;
				}
				/**
				 * 读取数据
				 */
				if (n == Constant.READ_SIZE) {
					strtemp = new String(temp);
					// str.append(strtemp);
					log.debug("读取数据：" + (dataBuffCount++) + strtemp);
				} else {
					strtemp = new String(temp, 0, n);
					log.debug("读取数据：" + (dataBuffCount++) + strtemp);
					// str = WDStringUtil.trimTail(str, "20");
				}
				/**
				 * 加密或解密数据
				 */
				if (testFlag) {
					// 测试加解密
					// result = encOrdecSJL(strtemp,encOrDec,IKms.DES_ECB);
					result = WD3DesCryptoUtil.ecb_decrypt(ZEKstrDES, strtemp,
							Padding.ZeroBytePadding);
				} else {
					// 生产加解密
					// log.debug("到达数据解密函数前。");
					result = encOrdecSJJ(strtemp, ZEKstrDES, encOrDec,
							IKms.DES_ECB);
				}
				log.debug(result);
				// log.debug("加密数据：" + result);

			} while ((n = din.read(temp)) != -1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			throw new Exception(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			try {
				// 处理最后一个数据块，删80补位
				result = deleteEightZero(result);
				log.debug("before_hex_decode::" + result);
				log.debug(Hex.decode(result));
				bufferedOutputStream.write(Hex.decode(result));

				fis.close();
				din.close();
				bufferedOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
				throw new Exception(e.getMessage());
			}
		}
	}
}
