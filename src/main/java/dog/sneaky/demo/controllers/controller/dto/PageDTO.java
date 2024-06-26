package dog.sneaky.demo.controllers.controller.dto;

import dog.sneaky.demo.common.DTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T extends DTO> {
    private long total;
    private List<?> rows;
}
