/*package com.taotaoti.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;

import org.slf4j.Logger;

import com.brooksandrus.utils.swf.PackedBitObj;
import com.brooksandrus.utils.swf.SWFCompression;
import com.brooksandrus.utils.swf.SWFCompressor;
import com.brooksandrus.utils.swf.SWFDecompressor;
import com.taotaoti.common.log.AopLogFactory;

*//**
 * @author genglei01
 * @version beidou-1.3.16 
 * the maximum number of iteration, avoid the infinite loop
 *//*
public class SWFHeader2 extends SWFCompression {

	private static final Logger LOG = AopLogFactory.getLogger(SWFHeader2.class);
	
	private String signature;

	private String compressionType;

	private int version;

	private long size;

	private int nbits;

	private int xmax;

	private int ymax;

	private int width;

	private int height;

	private int frameRate;

	private int frameCount;

	public static String COMPRESSED = "compressed";

	public static String UNCOMPRESSED = "uncompressed";
	
	*//**
	 * @author genglei01
	 * @version beidou-1.3.16 
	 * the maximum number of iteration, avoid the infinite loop
	 *//*
	private int maxNumIterations = 1024;

	public SWFHeader2() {
		super();
	}

	public SWFHeader2(File file) {
		try {
			parseHeader(file);
		} catch (Exception e) {
			LOG.warn(e.getMessage());
		}
	}
	
	public SWFHeader2(File file, int num) {
		try {
			parseHeader(file);
			maxNumIterations = num;
		} catch (Exception e) {
			LOG.warn(e.getMessage());
		}
	}

	public SWFHeader2(byte[] data) {
		try {
			byte[] temp = new byte[readFullSize(data) + 8];
			System.arraycopy(data, 0, temp, 0, data.length);
			parseHeader(temp);
		} catch (Exception e) {
			LOG.warn(e.getMessage());
		}
	}
	
	public SWFHeader2(byte[] data, int num) {
		try {
			byte[] temp = new byte[readFullSize(data) + 8];
			System.arraycopy(data, 0, temp, 0, data.length);
			parseHeader(temp);
		} catch (Exception e) {
			LOG.warn(e.getMessage());
		}
	}

	public SWFHeader2(String fileName) {
		try {
			parseHeader(new File(fileName));
		} catch (Exception e) {
			LOG.warn(e.getMessage());
		}
	}
	
	public SWFHeader2(String fileName, int num) {
		try {
			parseHeader(new File(fileName));
			maxNumIterations = num;
		} catch (Exception e) {
			LOG.warn(e.getMessage());
		}
	}

	public void parseHeader(File file) throws Exception {
		FileInputStream fis = null;
		byte[] temp = new byte[readFullSize(file)];// read the whole file in
													// maybe--should maybe read
													// just the header and then
													// determine the true length
													// by looking at the
													// header's size property
		// byte[] temp = new byte[47];//read just the header instead of the whole file

		try {
			fis = new FileInputStream(file);
			fis.read(temp);
			fis.close();
		} catch (IOException e) {
			LOG.warn(e.getMessage());
		}

		parseHeader(temp);
	}

	private void parseHeader(byte[] temp) throws Exception {
		byte[] swf = null;

		if (!isSWF(temp)) {
			throw new Exception(
					"File does not appear to be a swf - incorrect file signature");
		} else {
			signature = "" + (char) temp[0] + (char) temp[1] + (char) temp[2];
		}

		if (isCompressed(temp[0])) {
			swf = uncompress(temp);
			compressionType = SWFHeader2.COMPRESSED;
		} else {
			swf = temp;
			compressionType = SWFHeader2.UNCOMPRESSED;
		}

		// System.out.println( "swf byte array length: " + swf.length );

		// version is the 4th byte of a swf;
		version = swf[3];

		// bytes 5 - 8 represent the size in bytes of a swf
		size = readSize(swf);

		// Stage dimensions are stored in a rect

		nbits = ((swf[8] & 0xff) >> 3);

		PackedBitObj pbo = readPackedBits(swf, 8, 5, nbits);

		PackedBitObj pbo2 = readPackedBits(swf, pbo.nextByteIndex,
				pbo.nextBitIndex, nbits);

		PackedBitObj pbo3 = readPackedBits(swf, pbo2.nextByteIndex,
				pbo2.nextBitIndex, nbits);

		PackedBitObj pbo4 = readPackedBits(swf, pbo3.nextByteIndex,
				pbo3.nextBitIndex, nbits);

		xmax = pbo2.value;
		ymax = pbo4.value;

		width = convertTwipsToPixels(xmax);
		height = convertTwipsToPixels(ymax);

		int bytePointer = pbo4.nextByteIndex + 2;

		frameRate = swf[bytePointer];
		bytePointer++;

		int fc1 = swf[bytePointer] & 0xFF;
		bytePointer++;

		int fc2 = swf[bytePointer] & 0xFF;
		bytePointer++;

		frameCount = (fc2 << 8) + fc1;
	}

	public void read(byte[] output, byte[] input, int offset) {
		System.arraycopy(input, offset, output, 0, output.length - offset);
	}

	public PackedBitObj readPackedBits(byte[] bytes, int byteMarker,
			int bitMarker, int length) {
		int total = 0;
		int shift = 7 - bitMarker;
		int counter = 0;
		int bitIndex = bitMarker;
		int byteIndex = byteMarker;

		while (counter < length) {
			for (int i = bitMarker; i < 8; i++) {
				int bit = ((bytes[byteMarker] & 0xff) >> shift) & 1;
				total = (total << 1) + bit;
				bitIndex = i;
				shift--;
				counter++;

				if (counter == length) {
					break;
				}
			}
			byteIndex = byteMarker;
			byteMarker++;
			bitMarker = 0;
			shift = 7;
		}
		return new PackedBitObj(bitIndex, byteIndex, total);
	}

	public int convertTwipsToPixels(int twips) {
		return twips / 20;
	}

	public int convertPixelsToTwips(int pixels) {
		return pixels * 20;
	}

	public boolean isSWF(byte[] signature) {
		String sig = "" + (char) signature[0] + (char) signature[1]
				+ (char) signature[2];

		if (sig.equals("FWS") || sig.equals("CWS")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCompressed(int firstByte) {
		if (firstByte == 67) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCompressed() {
		boolean result = false;
		if (signature.equalsIgnoreCase("CWS")) {
			result = true;
		}
		return result;
	}

	public byte[] compress(byte[] bytes) {

		return new SWFCompressor().compress(bytes);
	}

	public byte[] uncompress(byte[] bytes) throws DataFormatException, IOException {
		return new SWFDecompressor(maxNumIterations).uncompress(bytes);
	}

	*//**
	 * @return the frameCount
	 *//*
	public int getFrameCount() {
		return frameCount;
	}

	*//**
	 * @return the frameRate
	 *//*
	public int getFrameRate() {
		return frameRate;
	}

	*//**
	 * @return the nbits
	 *//*
	public int getNbits() {
		return nbits;
	}

	*//**
	 * @return the signature
	 *//*
	public String getSignature() {
		return signature;
	}

	*//**
	 * @return the size
	 *//*
	public long getSize() {
		return size;
	}

	*//**
	 * @return the version
	 *//*
	public int getVersion() {
		return version;
	}

	*//**
	 * @return the xmax
	 *//*
	public int getXmax() {
		return xmax;
	}

	*//**
	 * @return the ymax
	 *//*
	public int getYmax() {
		return ymax;
	}

	*//**
	 * @return the compressionType
	 *//*
	public String getCompressionType() {
		return compressionType;
	}

	*//**
	 * @return the height
	 *//*
	public int getHeight() {
		return height;
	}

	*//**
	 * @return the width
	 *//*
	public int getWidth() {
		return width;
	}

}
*/