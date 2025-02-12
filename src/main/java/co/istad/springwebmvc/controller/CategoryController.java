package co.istad.springwebmvc.controller;import co.istad.springwebmvc.dto.CategoryRequest;import co.istad.springwebmvc.dto.CategoryResponse;import co.istad.springwebmvc.model.Product;import co.istad.springwebmvc.service.CategoryService;import io.swagger.v3.oas.annotations.Operation;import io.swagger.v3.oas.annotations.media.Content;import io.swagger.v3.oas.annotations.media.Schema;import io.swagger.v3.oas.annotations.responses.ApiResponse;import io.swagger.v3.oas.annotations.responses.ApiResponses;import jakarta.validation.Valid;import lombok.RequiredArgsConstructor;import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.*;import java.awt.print.Book;import java.util.HashMap;import java.util.List;import java.util.Map;@RestController@RequestMapping("/api/v1/categories")@RequiredArgsConstructorpublic class CategoryController {    private final CategoryService categoryService;    @GetMapping("/{id}")    CategoryResponse findCategoryById(@PathVariable Integer id){        return categoryService.findCategoryById(id);    }    @ResponseStatus(HttpStatus.CREATED)    @PostMapping    void createNewCategory(@Valid @RequestBody CategoryRequest categoryRequest){        categoryService.createNewCategory(categoryRequest);    }    @PutMapping("/{id}")    CategoryResponse editCategoryById(@PathVariable Integer id, @Valid @RequestBody CategoryRequest categoryRequest){        return categoryService.editCategoryById(id, categoryRequest);    }    @ResponseStatus(HttpStatus.NO_CONTENT)    @DeleteMapping("/{id}")    void deleteCategoryById(@PathVariable Integer id){        categoryService.deleteCategoryById(id);    }    @Operation(summary = "Get all categories")    @ApiResponses(value = {            @ApiResponse(responseCode = "200", description = "Found the book",                    content = { @Content(mediaType = "application/json",                            schema = @Schema(implementation =   Product.class)) }),            @ApiResponse(responseCode = "400", description = "Invalid id supplied",                    content = @Content),            @ApiResponse(responseCode = "404", description = "Book not found",                    content = @Content) })    @GetMapping    List<CategoryResponse> FindCategories(){        return categoryService.findCategories();    }}