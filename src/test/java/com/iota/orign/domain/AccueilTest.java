package com.iota.orign.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.iota.orign.web.rest.TestUtil;

public class AccueilTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Accueil.class);
        Accueil accueil1 = new Accueil();
        accueil1.setId(1L);
        Accueil accueil2 = new Accueil();
        accueil2.setId(accueil1.getId());
        assertThat(accueil1).isEqualTo(accueil2);
        accueil2.setId(2L);
        assertThat(accueil1).isNotEqualTo(accueil2);
        accueil1.setId(null);
        assertThat(accueil1).isNotEqualTo(accueil2);
    }
}
