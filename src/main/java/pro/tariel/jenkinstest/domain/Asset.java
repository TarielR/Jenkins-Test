package pro.tariel.jenkinstest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asset {
    private String dStoks;
    private String fStoks;
    private String bonds;
    private String shotTerms;
    private String other;
}
