package project.backend.api.filtering;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.backend.application.filtering.FilteringService;
import project.backend.application.filtering.request.FilterOptionsDto;
import project.backend.application.filtering.response.RegretsListDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/main/filter")
@Tag(name = "회고 필터 조회", description = "필터링 된 회고를 반환하는 api")
public class FilteringController {
    private final FilteringService filteringService;

    @Operation(summary = "회고 필터 api")
    @PostMapping
    public ResponseEntity<RegretsListDto> getRegretsFilter(@RequestBody FilterOptionsDto filterOptionsDto,
                                                           @RequestParam(value = "page", defaultValue = "0") int page,
                                                           @RequestParam(value = "size", defaultValue = "10") int size) {

        RegretsListDto regrets = filteringService.findRegretsByUserAttributes(filterOptionsDto, page, size);
        return ResponseEntity.ok(regrets);
    }
}
