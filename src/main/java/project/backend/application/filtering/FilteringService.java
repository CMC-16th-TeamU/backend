package project.backend.application.filtering;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.backend.application.filtering.request.FilterOptionsDto;
import project.backend.application.filtering.response.RegretsDto;
import project.backend.application.filtering.response.RegretsListDto;
import project.backend.domain.regret.RegretRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilteringService {
    private final RegretRepository regretRepository;

//    public List<RegretsDto> getFilterRegret(FilterOptionsDto filterOptionsDto){
//        regretRepository.findRegretsWithFilters(filterOptionsDto.getAge(),
//                filterOptionsDto.getGender(),
//                filterOptionsDto.getField(),
//                filterOptionsDto.getMajor());
//
//    }

    public Page<RegretsListDto> findRegretsByUserAttributes(FilterOptionsDto filterOptionsDto, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);

        return regretRepository.findRegretsByUserAttributes(filterOptionsDto.getBirthDate(),
                filterOptionsDto.getGender(),
                filterOptionsDto.getField(),
                filterOptionsDto.getMajor(),
                pageRequest);
    }
}
