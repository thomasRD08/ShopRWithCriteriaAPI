package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameServiceImpl extends CrudServiceImpl<Game, Long> implements GameService {
    private final GameRepository gameRepository;

    @Override
    protected JpaRepository<Game, Long> getRepository() {
        return gameRepository;
    }
}
