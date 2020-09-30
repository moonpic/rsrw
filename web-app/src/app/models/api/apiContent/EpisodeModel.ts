import { ServerModel } from './ServerModel'

export class EpisodeModel {
    id: String
    title: String
    image: String
    episode: number
    servers: ServerModel[]

}