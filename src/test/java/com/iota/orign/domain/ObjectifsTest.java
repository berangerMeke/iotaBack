package com.iota.orign.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.iota.orign.web.rest.TestUtil;

public class ObjectifsTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Objectifs.class);
        Objectifs objectifs1 = new Objectifs();
        objectifs1.setId(1L);
        Objectifs objectifs2 = new Objectifs();
        objectifs2.setId(objectifs1.getId());
        assertThat(objectifs1).isEqualTo(objectifs2);
        objectifs2.setId(2L);
        assertThat(objectifs1).isNotEqualTo(objectifs2);
        objectifs1.setId(null);
        assertThat(objectifs1).isNotEqualTo(objectifs2);
    }
}
