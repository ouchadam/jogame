package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.DocHelper;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class TypeSettingsParserTest {

    private ResourceSettingsParser resourceSettingsParser;

    @Before
    public void setUp() throws Exception {
        resourceSettingsParser = new ResourceSettingsParser();
    }

    @Test
    public void metal_per_hour_equals_2546() {
        ResourceSettings resourceSettings = resourceSettingsParser.parse(DocHelper.open("resource_settings.txt"));

        assertThat(resourceSettings.metal().hour).isEqualTo(2546);
    }

    @Test
    public void crystal_per_hour_equals_1273() {
        ResourceSettings resourceSettings = resourceSettingsParser.parse(DocHelper.open("resource_settings.txt"));

        assertThat(resourceSettings.crystal().hour).isEqualTo(1273);
    }

    @Test
    public void deut_per_hour_equals_148() {
        ResourceSettings resourceSettings = resourceSettingsParser.parse(DocHelper.open("resource_settings.txt"));

        assertThat(resourceSettings.deuterium().hour).isEqualTo(148);
    }

    @Test
    public void metal_per_day_equals_61104() {
        ResourceSettings resourceSettings = resourceSettingsParser.parse(DocHelper.open("resource_settings.txt"));

        assertThat(resourceSettings.metal().day).isEqualTo(61104);
    }

    @Test
    public void crystal_per_day_equals_30552() {
        ResourceSettings resourceSettings = resourceSettingsParser.parse(DocHelper.open("resource_settings.txt"));

        assertThat(resourceSettings.crystal().day).isEqualTo(30552);
    }

    @Test
    public void deut_per_day_equals_3552() {
        ResourceSettings resourceSettings = resourceSettingsParser.parse(DocHelper.open("resource_settings.txt"));

        assertThat(resourceSettings.deuterium().day).isEqualTo(3552);
    }

    @Test
    public void metal_per_week_equals_427728() {
        ResourceSettings resourceSettings = resourceSettingsParser.parse(DocHelper.open("resource_settings.txt"));

        assertThat(resourceSettings.metal().week).isEqualTo(427728);
    }

    @Test
    public void crystal_per_week_equals_213864() {
        ResourceSettings resourceSettings = resourceSettingsParser.parse(DocHelper.open("resource_settings.txt"));

        assertThat(resourceSettings.crystal().week).isEqualTo(213864);
    }

    @Test
    public void deut_per_week_equals_24864() {
        ResourceSettings resourceSettings = resourceSettingsParser.parse(DocHelper.open("resource_settings.txt"));

        assertThat(resourceSettings.deuterium().week).isEqualTo(24864);
    }

}
