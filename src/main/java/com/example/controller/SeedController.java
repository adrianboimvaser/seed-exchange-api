package com.example.controller;

import com.example.domain.Seed;
import com.example.mapper.SeedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "seeds", produces = "application/json; charset=utf-8")
public class SeedController {

    private final SeedMapper seedMapper;

    @Autowired
    public SeedController(SeedMapper seedMapper) {
        this.seedMapper = seedMapper;
    }

    @GetMapping
    private List<Seed> list() {
        return seedMapper.list();
    }

    @PostMapping
    private Seed create(@RequestBody @Validated Seed seed) {
        seed.setUserId(1L);
        seedMapper.insert(seed);
        return seedMapper.findById(seed.getId());
    }

    @GetMapping(value = "/{id}")
    private Seed get(@PathVariable("id") long id) {
        return seedMapper.findById(id);
    }

    @PutMapping(value = "/{id}")
    private Seed update(@PathVariable("id") long id, @RequestBody @Validated Seed seed) {
        seed.setId(id);
        seedMapper.update(seed);
        return seedMapper.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    private void delete(@PathVariable("id") long id) {
        seedMapper.delete(id);
    }
}
