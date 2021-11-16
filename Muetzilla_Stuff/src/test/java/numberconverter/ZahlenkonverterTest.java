package numberconverter;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ZahlenkonverterTest {
    @Test
    public void TestBinary1(){
        Zahlenkonverter zk = new Zahlenkonverter();
        assertEquals(Integer.toBinaryString(1), zk.convertDezToBinary(1));
    }
    @Test
    public void TestBinary5(){
        Zahlenkonverter zk = new Zahlenkonverter();
        assertEquals(Integer.toBinaryString(5), zk.convertDezToBinary(5));
    }
    @Test
    public void TestHex7(){
        Zahlenkonverter zk = new Zahlenkonverter();
        assertEquals(Integer.toHexString(7), zk.convertDezToHex(7).toLowerCase(Locale.ROOT));
    }
    @Test
    public void TestHex21(){
        Zahlenkonverter zk = new Zahlenkonverter();
        assertEquals(Integer.toHexString(21), zk.convertDezToHex(21).toLowerCase(Locale.ROOT));
    }
    @Test
    public void TestHex174(){
        Zahlenkonverter zk = new Zahlenkonverter();
        assertEquals(Integer.toHexString(174), zk.convertDezToHex(174).toLowerCase(Locale.ROOT));
    }
    @Test
    public void TestToAnyOctal(){
        Zahlenkonverter zk = new Zahlenkonverter();
        assertEquals(Integer.toOctalString(16), zk.convertDezToAny(16, 8).toLowerCase(Locale.ROOT));
    }
    @Test
    public void TestToAny21erSystem(){
        Zahlenkonverter zk = new Zahlenkonverter();
        assertEquals("g42i", zk.convertDezToAny(150000, 21).toLowerCase(Locale.ROOT));
    }
}