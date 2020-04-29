package pl.haladyj.wzjsontemplate.converter;

import org.springframework.stereotype.Component;
import pl.haladyj.wzjsontemplate.model.Wz;
import pl.haladyj.wzjsontemplate.service.dto.WzDto;

@Component
public class WzConverter implements ConvertWz<Wz, WzDto> {

    @Override
    public Wz toModel(WzDto wzDto) {
        Wz wz = new Wz();
        wz.setDescription(wzDto.getDescription());
        wz.setSn(wzDto.getSn());
        wz.setProducts(wzDto.getProducts());
        return wz;
    }

    @Override
    public WzDto toDto(Wz wz) {
        WzDto wzDto = new WzDto();
        wzDto.setDescription(wz.getDescription());
        wzDto.setSn(wz.getSn());
        wzDto.setCreatedAt(wz.getCreatedAt());
        return wzDto;
    }
}
