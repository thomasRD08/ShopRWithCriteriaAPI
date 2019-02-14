import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Game} from "../models/game";

@Injectable({
  providedIn: 'root'
})
export class GameService {
  constructor(private http: HttpClient) {
  }

  createGame(game: Game): Observable<Game> {
    return this.http.post<Game>('/api/products/games', game)
  }

  getGames(): Observable<Game[]> {
    return this.http.get<Game[]>('/api/products/games');
  }

  getGameById(id: number): Observable<Game> {
    return this.http.get<Game>(`/api/products/games/${id}`);
  }

  updateGameById(id: number, game: Game): Observable<Game> {
    return this.http.put<Game>(`/api/products/games/${id}`, game);
  }

  deleteGameById(id: number): Observable<any> {
    return this.http.delete<Game>(`/api/products/games/${id}`);
  }
}
