package project.backend.application.filtering;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import project.backend.application.filtering.request.FilterOptionsDto;
import project.backend.application.filtering.response.RegretsDto;
import project.backend.application.filtering.response.RegretsListDto;
import project.backend.domain.regret.Regret;
import project.backend.domain.regret.repository.RegretRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilteringService {
    private final RegretRepository regretRepository;

    public RegretsListDto findRegretsByUserAttributes(FilterOptionsDto filterOptionsDto, int page, int size) {

        String sortBy = filterOptionsDto.getSortBy() != null && filterOptionsDto.getSortBy().equalsIgnoreCase("ASC") ? "ASC" : "DESC";

        Sort sort = Sort.by(new Sort.Order(Sort.Direction.fromString(sortBy), "createdAt"));

        PageRequest pageRequest = PageRequest.of(page, size, sort);

        Page<Regret> regrets = regretRepository.findRegretsByUserAttributes(
                filterOptionsDto.getBirthDate(),
                filterOptionsDto.getGender(),
                filterOptionsDto.getField(),
                filterOptionsDto.getMajor(),
                pageRequest
        );

        boolean isLast = regrets.isLast();
        int totalPage = regrets.getTotalPages();
        long totalElement = regrets.getTotalElements();

        List<RegretsDto> regretsDtos = regrets.stream().map(RegretsDto::of).toList();

        return RegretsListDto.of(isLast, totalPage, totalElement, regretsDtos);
    }


}
