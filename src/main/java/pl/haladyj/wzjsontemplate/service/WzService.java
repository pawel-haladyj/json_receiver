package pl.haladyj.wzjsontemplate.service;

import org.springframework.stereotype.Service;
import pl.haladyj.wzjsontemplate.converter.WzConverter;
import pl.haladyj.wzjsontemplate.model.Wz;
import pl.haladyj.wzjsontemplate.repository.WzRepository;
import pl.haladyj.wzjsontemplate.service.dto.WzDto;
import pl.haladyj.wzjsontemplate.utils.WzUtils;

import java.time.Instant;

@Service
public class WzService {

    private final WzRepository wzRepository;
    private final WzConverter wzConverter;
    private final WzUtils wzUtils;

    public WzService(WzRepository wzRepository, WzConverter wzConverter, WzUtils wzUtils) {
        this.wzRepository = wzRepository;
        this.wzConverter = wzConverter;
        this.wzUtils = wzUtils;
    }

    public Wz createWz(WzDto wzDto){
        Wz wz = wzConverter.toModel(wzDto);

        wz.setSn(wzUtils.createSn());
        wz.setCreatedAt(wzUtils.now());
        wz.setProducts(wzUtils.updateMapContent(wz));

        return wzRepository.save(wz);
    }

}
