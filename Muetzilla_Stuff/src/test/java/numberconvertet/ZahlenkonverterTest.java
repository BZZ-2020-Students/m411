package numberconvertet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(Integer.toHexString(7), zk.convertDezToHex(7));
    }
    @Test
    public void TestHex21(){
        Zahlenkonverter zk = new Zahlenkonverter();
        assertEquals(Integer.toHexString(21), zk.convertDezToHex(21));
    }
    @Test
    public void TestHex174(){
        Zahlenkonverter zk = new Zahlenkonverter();
        assertEquals(Integer.toHexString(174), zk.convertDezToHex(174));
    }


}