package pl.haladyj.wzjsontemplate.service;

import org.springframework.stereotype.Service;
import pl.haladyj.wzjsontemplate.converter.WzConverter;
import pl.haladyj.wzjsontemplate.model.Wz;
import pl.haladyj.wzjsontemplate.repository.WzRepository;
import pl.haladyj.wzjsontemplate.service.dto.WzDto;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class WzService {

    private final WzRepository wzRepository;
    private final WzConverter wzConverter;

    public WzService(WzRepository wzRepository, WzConverter wzConverter) {
        this.wzRepository = wzRepository;
        this.wzConverter = wzConverter;
    }

    public Wz createWz(WzDto wzDto){
        Wz wz = wzConverter.toModel(wzDto);

        String snCode = createSn();
        wz.setSn(snCode);

        Instant now = Instant.now();
        wz.setCreatedAt(now);

        return wzRepository.save(wz);
    }

    private String createSn() {
        Instant date = Instant.now();
        int currentYear = Date.from(date).getYear() + 1900;
        int lastSnYear=0;

        Optional<String> lastSn = wzRepository.findMostRecentSnFromWz();
        String currentSn = "";

        int index = 0;

        if(lastSn.isPresent()){
            String lastSnExisting = lastSn.get();
            int lastIndexOfSlash = lastSnExisting.lastIndexOf("/");
            lastSnYear = Integer.parseInt(lastSnExisting.substring(lastIndexOfSlash-4,lastIndexOfSlash));

            index = Integer.parseInt(lastSnExisting.substring(lastIndexOfSlash+1));
            index++;

            currentSn = "WZ/TOWARY/"+currentYear+"/"+index;
        } else {
            currentSn = "WZ/TOWARY/"+currentYear+"/1";
        }

        if(lastSnYear!=currentYear){
            currentSn = "WZ/TOWARY/"+currentYear+"/1";
        }

        return currentSn;
    }
}
