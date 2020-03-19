package pro.tariel.jenkinstest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Item extends BaseEntity {
    private String name;
    private LocalDateTime created;
    private Asset asset;
}
