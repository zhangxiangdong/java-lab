package com.zhang.factory.abs2;

import com.zhang.factory.abs2.elf.ElfArmy;
import com.zhang.factory.abs2.elf.ElfCastle;
import com.zhang.factory.abs2.elf.ElfKing;
import com.zhang.factory.abs2.elf.ElfKingdomFactory;
import com.zhang.factory.abs2.orc.OrcArmy;
import com.zhang.factory.abs2.orc.OrcCastle;
import com.zhang.factory.abs2.orc.OrcKing;
import com.zhang.factory.abs2.orc.OrcKingdomFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhangxiangdong on 2016/11/22.
 */
public class AbstractFactoryTest {

    private App app = new App();
    private KingdomFactory elfFactory;
    private KingdomFactory orcFactory;

    @Before
    public void setUp() {
        elfFactory = new ElfKingdomFactory();
        orcFactory = new OrcKingdomFactory();
    }

    @Test
    public void king() {
        final King elfKing = app.getKing(elfFactory);
        assertTrue(elfKing instanceof ElfKing);
        assertEquals(ElfKing.NAME, elfKing.getName());
        final King orcKing = app.getKing(orcFactory);
        assertTrue(orcKing instanceof OrcKing);
        assertEquals(OrcKing.NAME, orcKing.getName());
    }

    @Test
    public void castle() {
        final Castle elfCastle = app.getCastle(elfFactory);
        assertTrue(elfCastle instanceof ElfCastle);
        assertEquals(ElfCastle.NAME, elfCastle.getName());
        final Castle orcCastle = app.getCastle(orcFactory);
        assertTrue(orcCastle instanceof OrcCastle);
        assertEquals(OrcCastle.NAME, orcCastle.getName());
    }

    @Test
    public void army() {
        final Army elfArmy = app.getArmy(elfFactory);
        assertTrue(elfArmy instanceof ElfArmy);
        assertEquals(ElfArmy.NUMBER, elfArmy.getNumber());
        final Army orcArmy = app.getArmy(orcFactory);
        assertTrue(orcArmy instanceof OrcArmy);
        assertEquals(OrcArmy.NUMBER, orcArmy.getNumber());
    }

}
