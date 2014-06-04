package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.DocHelper;
import com.ouchadam.jogame.domain.Research;
import com.ouchadam.jogame.domain.Status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ResearchParserTest {

    private ResearchParser researchParser;

    @Before
    public void setUp() throws Exception {
        researchParser = new ResearchParser();
    }

    @Test
    public void parse() throws Exception {
        List<Research> resources = researchParser.parse(DocHelper.open("research_error.txt"));

        assertResearch(resources.get(0), Research.Type.ENERGY_TECHNOLOGY, 4, Status.DISABLED, 113);
        assertResearch(resources.get(resources.size() - 1), Research.Type.ARMOUR_TECHNOLOGY, 7, Status.DISABLED, 111);
    }

    private static void assertResearch(Research research, Research.Type type, int level, Status status, int id) {
        assertThat(research.getType()).isEqualTo(type);
        assertThat(research.getLevel()).isEqualTo(level);
        assertThat(research.getStatus()).isEqualTo(status);
        assertThat(research.getId()).isEqualTo(id);
    }

}
