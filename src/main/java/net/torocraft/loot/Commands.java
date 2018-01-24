package net.torocraft.loot;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class Commands extends CommandBase {

  private static final UUID TEST_ID = UUID.fromString("2027e16a-6edd-11e7-907b-a6006ad3dba0");

  @Override
  @Nonnull
  public String getName() {
    return "loot";
  }

  @Override
  @Nonnull
  public String getUsage(@Nullable ICommandSender sender) {
    return "commands.nemesis_system.usage";
  }

  @Override
  public int getRequiredPermissionLevel() {
    return 2;
  }

  @Override
  public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender,
      @Nonnull String[] args) throws CommandException {

    if (args.length < 1) {
      throw new WrongUsageException("commands.loot.usage");
    }

    String command = args[0];

    switch (command) {
      default:
        throw new WrongUsageException("commands.loot.command_not_found");
    }
  }

  @Override
  @Nonnull
  public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender,
      String[] args, @Nullable BlockPos targetPos) {
    if (args.length == 1) {
      return getListOfStringsMatchingLastWord(args, "enter");
    }
    String command = args[0];
    switch (command) {
      case "enter":
        return tabCompletionsForEnter(args);
      default:
        return Collections.emptyList();
    }
  }

  private List<String> tabCompletionsForEnter(String[] args) {
    if (args.length == 2) {
      return getListOfStringsMatchingLastWord(args, numbers());
    }
    return Collections.emptyList();
  }

  private String[] numbers() {
    String[] numbers = new String[10];
    for (int i = 0; i < 10; i++) {
      numbers[i] = Integer.toString(i, 10);
    }
    return numbers;
  }
}
