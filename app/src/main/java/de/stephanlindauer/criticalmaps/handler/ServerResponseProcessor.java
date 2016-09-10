package de.stephanlindauer.criticalmaps.handler;

import org.json.JSONObject;

import javax.inject.Inject;

import de.stephanlindauer.criticalmaps.events.Events;
import de.stephanlindauer.criticalmaps.model.ChatModel;
import de.stephanlindauer.criticalmaps.model.OtherUsersLocationModel;
import de.stephanlindauer.criticalmaps.provider.EventBusProvider;

public class ServerResponseProcessor {

    private final OtherUsersLocationModel otherUsersLocationModel;
    private final EventBusProvider eventService;
    private final ChatModel chatModel;

    @Inject
    public ServerResponseProcessor(OtherUsersLocationModel otherUsersLocationModel, EventBusProvider eventService, ChatModel chatModel) {
        this.otherUsersLocationModel = otherUsersLocationModel;
        this.eventService = eventService;
        this.chatModel = chatModel;
    }

    public void process(final String jsonString) {
        try {
            final JSONObject jsonObject = new JSONObject(jsonString);
            otherUsersLocationModel.setNewJSON(jsonObject.getJSONObject("locations"));
            chatModel.setNewJson(jsonObject.getJSONObject("chatMessages"));
            eventService.post(Events.NEW_SERVER_RESPONSE_EVENT);
        } catch (Exception ignored) {
        }
    }
}
