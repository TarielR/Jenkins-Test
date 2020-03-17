package pro.tariel.jenkinstest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Item extends BaseEntity {
    private String name;
    private LocalDateTime created;
    private Asset asset;
}
