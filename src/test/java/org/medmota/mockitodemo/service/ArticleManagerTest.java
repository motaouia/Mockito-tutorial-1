package org.medmota.mockitodemo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medmota.mockitodemo.entities.ArticleDatabase;
import org.medmota.mockitodemo.entities.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ArticleManagerTest {

	@Mock
    ArticleDatabase database;

    @Mock
    User user;

    @InjectMocks
    private ArticleManager manager; 

    @Test
    void shouldDoSomething() {
       // TODO perform some tests with this managers
    }

}
