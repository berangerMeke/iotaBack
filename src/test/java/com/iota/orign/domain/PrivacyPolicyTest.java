package com.iota.orign.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.iota.orign.web.rest.TestUtil;

public class PrivacyPolicyTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PrivacyPolicy.class);
        PrivacyPolicy privacyPolicy1 = new PrivacyPolicy();
        privacyPolicy1.setId(1L);
        PrivacyPolicy privacyPolicy2 = new PrivacyPolicy();
        privacyPolicy2.setId(privacyPolicy1.getId());
        assertThat(privacyPolicy1).isEqualTo(privacyPolicy2);
        privacyPolicy2.setId(2L);
        assertThat(privacyPolicy1).isNotEqualTo(privacyPolicy2);
        privacyPolicy1.setId(null);
        assertThat(privacyPolicy1).isNotEqualTo(privacyPolicy2);
    }
}
