package io.swagger.v3.jaxrs2.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author djl
 */
public class GenericsResource<T> {
   
    @GET
    @Path("/1")
    @Operation(operationId = "operationId",
            summary = "Operation Summary",
            description = "Operation Description",
            tags = {"Example Tag", "Second Tag"},
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "subscriptionId",
                            required = true, description = "parameter description",
                            allowEmptyValue = true, allowReserved = true,
                            schema = @Schema(
                                    type = "string",
                                    format = "uuid",
                                    description = "the generated UUID",
                                    readOnly = true)
                    )},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "voila!",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponsesResource.SampleResponseSchema.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "default",
                            description = "boo",
                            content = @Content(
                                    mediaType = "*/*",
                                    schema = @Schema(implementation = ResponsesResource.GenericError.class)
                            )
                    )
            }
    )
    public Response getSummaryAndDescription() {
        return Response.ok().entity("ok").build();
    }
}
