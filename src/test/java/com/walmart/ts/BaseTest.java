package com.walmart.ts;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/TicketingServiceTestContext.xml" })
public abstract class BaseTest {


    @Before
    public final void setUp() throws Exception
    {

        setupInternal();
    }

    protected abstract void setupInternal() throws Exception;

}