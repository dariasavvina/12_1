package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void TestNumber(){
        List<Integer> expecteds = new ArrayList<>();
        expecteds.add(1);
        expecteds.add(6);
        expecteds.add(9);
        List<Integer> actual = new ArrayList<>();
        actual.add(Integer.decode("1"));
        actual.add(Integer.decode("6"));
        actual.add(Integer.decode("9"));
        Assert.assertEquals(expecteds, actual);
    }

    @Test
    public void TestNegativeNumber(){
        List<Integer> expecteds = new ArrayList<>();
        expecteds.add(-1);
        expecteds.add(-6);
        expecteds.add(-9);
        List<Integer> actual = new ArrayList<>();
        actual.add(Integer.decode("-1"));
        actual.add(Integer.decode("-6"));
        actual.add(Integer.decode("-9"));
        Assert.assertEquals(expecteds, actual);
    }

    @Test
    public void TestPositiveNumber(){
        List<Integer> expecteds = new ArrayList<>();
        expecteds.add(1);
        expecteds.add(6);
        expecteds.add(9);
        List<Integer> actual = new ArrayList<>();
        actual.add(Integer.decode("+1"));
        actual.add(Integer.decode("+6"));
        actual.add(Integer.decode("+9"));
        Assert.assertEquals(expecteds, actual);
    }


    @Test(expected = NumberFormatException.class)
    public void TestEmpty(){
        Integer temp = Integer.decode("");
    }

    @Test
    public void TestHexNumber(){
        List<Integer> expecteds = new ArrayList<>();
        expecteds.add(0x0000152D);
        expecteds.add(0X0000152D);
        expecteds.add(0x00000001);
        List<Integer> actual = new ArrayList<>();
        actual.add(Integer.decode("0x0000152D"));
        actual.add(Integer.decode("0X0000152D"));
        actual.add(Integer.decode("0x00000001"));
        Assert.assertEquals(expecteds, actual);
    }

    @Test
    public void TestHexNumber2(){
        List<Integer> expecteds = new ArrayList<>();
        expecteds.add(0x0000152D);
        expecteds.add(0X0000152D);
        expecteds.add(0x00000001);
        List<Integer> actual = new ArrayList<>();
        actual.add(Integer.decode("#0000152D"));
        actual.add(Integer.decode("#0000152D"));
        actual.add(Integer.decode("#00000001"));
        Assert.assertEquals(expecteds, actual);
    }

    @Test
    public void TestOctalNumber(){
        List<Integer> expecteds = new ArrayList<>();
        expecteds.add(01234343);
        expecteds.add(01234543);
        expecteds.add(01234743);
        List<Integer> actual = new ArrayList<>();
        actual.add(Integer.decode("01234343"));
        actual.add(Integer.decode("01234543"));
        actual.add(Integer.decode("01234743"));
        Assert.assertEquals(expecteds, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void TestIncorrectNumber(){
        Integer temp = Integer.decode("fgdgdf");
    }

    @Test(expected = NumberFormatException.class)
    public void TestOverflowInteger(){
        Integer temp = Integer.decode("10000000000000");
    }

    @Test(expected = NumberFormatException.class)
    public void TestWrongPosition(){
        Integer temp = Integer.decode("2-3");
    }
}