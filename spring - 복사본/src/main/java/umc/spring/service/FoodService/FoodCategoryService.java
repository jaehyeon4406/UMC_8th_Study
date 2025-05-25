package umc.spring.service.FoodService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean allExistByIds(List<Long> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}
