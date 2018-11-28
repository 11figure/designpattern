package com.leven.App;

import com.leven.command.CommandServiceImpl;
import com.leven.command.ICommandService;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:19 2018/8/28
 * @Modified By:
 */
public class App {

    public static void main(String[] args) {
        ICommandService commands = new CommandServiceImpl();
        commands.authorCreated("eVans", "Eriic Evans","eEvans@email.com");

    }
}
